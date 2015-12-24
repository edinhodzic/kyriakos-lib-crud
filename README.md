# About

A repository abstraction library based on three traits:

- `AbstractPartialCrudRepository` defines an interface for all CRUD operations except the update operation as this can either be a whole update or a partial update
- `WholeUpdates` defines an interface for whole update
- `PartialUpdates` defines an interface for partial updates

# Usage

Say we have a `Person` object:

```scala
case class Person(firstname: String, lastname: String) extends Identifiable
```

If we want a repository capable of whole updates:

```scala
class PersonRepository extends AbstractPartialCrudRepository[Person] with WholeUpdates[Person] {

  override def create(resource: Person): Try[Person] = ???

  override def read(resourceId: String): Try[Option[Person]] = ???

  override def update(resource: Person): Try[Option[Person]] = ??? // this handles whole updates

  override def delete(resourceId: String): Try[Option[Unit]] = ???

}
```
Alternatively, if we want a repository capable of partial updates:

```scala
class PersonRepository extends AbstractPartialCrudRepository[Person] with PartialUpdates[Person] {

  override def create(resource: Person): Try[Person] = ???

  override def read(resourceId: String): Try[Option[Person]] = ???

  override def update(resourceId: String, updatePayload: String): Try[Option[AnyRef]] = ??? // this handles partial updates

  override def delete(resourceId: String): Try[Option[Unit]] = ???

}
```