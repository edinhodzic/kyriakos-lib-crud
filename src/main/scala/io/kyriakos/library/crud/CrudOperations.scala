package io.kyriakos.library.crud

import io.kyriakos.library.domain.Identifiable

import scala.util.Try

trait CrudOperations[T <: Identifiable] {

  def create(resource: T): Try[T]

  def read(resourceId: String): Try[Option[T]]

  def update(resource: T): Try[Option[T]]

  def update(resourceId: String, updatePayload: String): Try[Option[AnyRef]]

  def delete(resourceId: String): Try[Option[Unit]]

}
