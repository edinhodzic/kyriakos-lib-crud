package io.otrl.library.crud

import io.otrl.library.domain.Identifiable

import scala.util.Try

trait PartialCrudOperations[T <: Identifiable] {

  def create(resource: T): Try[T]

  def read(resourceId: String): Try[Option[T]]

  def delete(resourceId: String): Try[Option[Unit]]

}
