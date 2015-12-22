package io.otrl.library.repository

import scala.util.Try

trait Queryable[T] {

  def query(queryString: String): Try[Paginated[T]]

}

// TODO think about moving to a different library?
