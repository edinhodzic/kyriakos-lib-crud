package io.otrl.library.crud

import scala.util.Try

import io.otrl.library.domain.Identifiable

// TODO rename to PartialCrudOperations
trait PartialCrudOperations[T <: Identifiable] {

  def create(resource: T): Try[T]

  def read(resourceId: String): Try[Option[T]]

  //def update(resource: T): Try[Option[T]]

  def delete(resourceId: String): Try[Option[Unit]]

}
