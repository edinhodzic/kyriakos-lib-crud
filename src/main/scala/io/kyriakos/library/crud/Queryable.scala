package io.kyriakos.library.crud

import scala.util.Try

trait Queryable[T] {

  def query(queryString: String): Try[Paginated[T]]

}
