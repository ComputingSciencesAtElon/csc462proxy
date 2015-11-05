package headfirst.proxy.javanoproxy;

public abstract class PersonProxy implements PersonBean {
  protected PersonBean person;

  public PersonProxy(PersonBean person) {
    this.person = person;
  }

  public String getName() {
    return person.getName();
  }

  public String getGender() {
    return person.getGender();
  }

  public String getInterests() {
    return person.getInterests();
  }

  public int getHotOrNotRating() {
    return person.getHotOrNotRating();
  }
}
