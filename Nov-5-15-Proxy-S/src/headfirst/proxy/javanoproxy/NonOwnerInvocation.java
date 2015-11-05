package headfirst.proxy.javanoproxy;

public class NonOwnerInvocation extends PersonProxy {

  public NonOwnerInvocation(PersonBean person) {
    super(person);
  }

  public void setName(String name) {
    throw new UnsupportedOperationException();
  }

  public void setGender(String gender) {
    throw new UnsupportedOperationException();
  }

  public void setInterests(String interests) {
    throw new UnsupportedOperationException();
  }

  public void setHotOrNotRating(int rating) {
    person.setHotOrNotRating(rating);
  }
}
