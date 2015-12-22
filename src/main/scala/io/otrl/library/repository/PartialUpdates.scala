package io.otrl.library.repository

import io.otrl.library.domain.Identifiable

import scala.util.Try

trait PartialUpdates[T <: Identifiable] {

  def update(resourceId: String, updatePayload: String): Try[Option[AnyRef]]

}
