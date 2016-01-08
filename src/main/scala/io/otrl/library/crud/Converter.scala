package io.otrl.library.crud

// TODO consider using json4s in implementations
trait Converter[A, B] {

  def serialise(subject: A): B

  def deserialise(subject: B): A

}

