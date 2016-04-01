package io.otrl.library.crud.kamon

import com.typesafe.scalalogging.LazyLogging
import io.otrl.library.crud.{CrudOperations, Paginated, Queryable}
import io.otrl.library.domain.Identifiable
import io.otrl.library.utils.ManifestUtils
import kamon.Kamon
import kamon.metric.instrument.Counter
import kamon.trace.SegmentCategory.Database
import kamon.trace.Tracer

import scala.language.postfixOps
import scala.util.Try

/**
  * Wraps a repository and starts a Kamon segment for each repository function.
  * @param repository the repository to wrap
  */
class KamonRepositoryWrapper[T <: Identifiable]
(repository: CrudOperations[T] with Queryable[T])(implicit manifest: Manifest[T])
  extends CrudOperations[T] with Queryable[T] with LazyLogging {

  private lazy val domain: String = ManifestUtils.simpleName(manifest)
  private lazy val createCounter: Counter = Kamon.metrics.counter(s"$domain-create-counter")
  private lazy val readCounter: Counter = Kamon.metrics.counter(s"$domain-read-counter")
  private lazy val wholeUpdateCounter: Counter = Kamon.metrics.counter(s"$domain-whole-update-counter")
  private lazy val patialUpdateCounter: Counter = Kamon.metrics.counter(s"$domain-partial-update-counter")
  private lazy val deleteCounter: Counter = Kamon.metrics.counter(s"$domain-delete-counter")
  private lazy val queryCounter: Counter = Kamon.metrics.counter(s"$domain-query-counter")

  override def create(resource: T): Try[T] =
    kamonSegment(s"create-$domain-segment", createCounter) {
      repository create resource
    }

  override def read(resourceId: String): Try[Option[T]] =
    kamonSegment(s"read-$domain-segment", readCounter) {
      repository read resourceId
    }

  override def update(resource: T): Try[Option[T]] =
    kamonSegment(s"whole-update-$domain-segment", wholeUpdateCounter) {
      repository update resource
    }

  override def update(resourceId: String, updatePayload: String): Try[Option[AnyRef]] =
    kamonSegment(s"partial-update-$domain-segment", patialUpdateCounter) {
      repository update(resourceId, updatePayload)
    }

  override def delete(resourceId: String): Try[Option[Unit]] =
    kamonSegment(s"delete-$domain-segment", deleteCounter) {
      repository delete resourceId
    }

  override def query(queryString: String): Try[Paginated[T]] =
    kamonSegment(s"query-$domain-segment", queryCounter) {
      repository query queryString
    }

  private def kamonSegment[T](name: String, counter: Counter)(function: => T): T = {
    // TODO not sure about the 'library' parameter, need something more meaningful
    logger debug s"starting kamon segment [$name, Database, library]"
    Tracer.currentContext.withNewSegment(name, Database, "library") {
      counter increment()
      function
    }
  }

}
