package io.otrl.library.crud

import io.otrl.library.domain.Identifiable

import scala.concurrent.Future

trait AsyncCrudOperations[T <: Identifiable] {

  def create(resource: T): Future[T]

  def read(resourceId: String): Future[Option[T]]

  def update(resource: T): Future[Option[T]]

  def update(resourceId: String, updatePayload: String): Future[Option[AnyRef]]

  def delete(resourceId: String): Future[Option[Unit]]

}
