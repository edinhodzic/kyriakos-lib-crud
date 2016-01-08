package io.otrl.library.crud

trait Converter[A, B] {

  def serialise(subject: A): B

  def deserialise(subject: B): A

}

// TODO think about moving to a different library?
