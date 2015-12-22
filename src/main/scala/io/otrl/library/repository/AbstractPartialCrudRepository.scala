package io.otrl.library.repository

import scala.util.Try

import io.otrl.library.domain.Identifiable

trait AbstractPartialCrudRepository[T <: Identifiable] {

  def create(resource: T): Try[T]

  def read(resourceId: String): Try[Option[T]]

  //def update(resource: T): Try[Option[T]]

  def delete(resourceId: String): Try[Option[Unit]]

}
