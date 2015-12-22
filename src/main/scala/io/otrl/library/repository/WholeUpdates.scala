package io.otrl.library.repository

import io.otrl.library.domain.Identifiable

import scala.util.Try

trait WholeUpdates[T <: Identifiable] {

  def update(resource: T): Try[Option[T]]

}
