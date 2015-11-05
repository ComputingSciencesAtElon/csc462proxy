package headfirst.proxy.javanoproxy;

public class OwnerInvocation extends PersonProxy {

  public OwnerInvocation(PersonBean person) {
    super(person);
  }

  public void setName(String name) {
    person.setName(name);
  }

  public void setGender(String gender) {
    person.setGender(gender);
  }

  public void setInterests(String interests) {
    person.setInterests(interests);
  }

  public void setHotOrNotRating(int rating) {
    throw new UnsupportedOperationException();
  }
}
