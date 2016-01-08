# About

A repository abstraction library based on the following abstractions:

![Repository abstractions](https://cloud.githubusercontent.com/assets/4981314/12087457/f261ceaa-b2ca-11e5-8df4-fade5f8ee18e.jpg)

# Usage

Say we have a `Person` object:

```scala
case class Person(firstname: String, lastname: String) extends Identifiable
```

If we want a repository capable of whole updates:

```scala
class PersonRepository extends PartialCrudOperations[Person] with WholeUpdates[Person] {

  override def create(resource: Person): Try[Person] = ???

  override def read(resourceId: String): Try[Option[Person]] = ???

  override def update(resource: Person): Try[Option[Person]] = ??? // this handles whole updates

  override def delete(resourceId: String): Try[Option[Unit]] = ???

}
```
Alternatively, if we want a repository capable of partial updates:

```scala
class PersonRepository extends PartialCrudOperations[Person] with PartialUpdates[Person] {

  override def create(resource: Person): Try[Person] = ???

  override def read(resourceId: String): Try[Option[Person]] = ???

  override def update(resourceId: String, updatePayload: String): Try[Option[AnyRef]] = ??? // this handles partial updates

  override def delete(resourceId: String): Try[Option[Unit]] = ???

}
```

# What's next?

- [ ] rename this project to `otrl-lib-crud`
- [ ] consider using HTTP PATCH in addition to PUT as per [RFC 5789](http://tools.ietf.org/html/rfc5789)

