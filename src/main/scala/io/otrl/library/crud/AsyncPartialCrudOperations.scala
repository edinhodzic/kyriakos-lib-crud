package io.otrl.library.crud

import io.otrl.library.domain.Identifiable

import scala.concurrent.Future

trait AsyncPartialCrudOperations[T <: Identifiable] {

  def create(resource: T): Future[T]

  def read(resourceId: String): Future[Option[T]]

  def delete(resourceId: String): Future[Option[Unit]]

}
