package alexander.sergeev;

import java.util.Objects;

class DogComparableImpl implements Comparable<DogComparableImpl> {

    private final String nickname;

    public DogComparableImpl(String nickname){
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public int compareTo(DogComparableImpl dog) {
        return this.nickname.toLowerCase().compareTo(dog.nickname.toLowerCase());
    }

    @Override
    public boolean equals(Object dog) {
        if (this == dog) return true;
        if (!(dog instanceof DogComparableImpl)) return false;
        return Objects.equals(this.nickname.toLowerCase(), ((DogComparableImpl) dog).nickname.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

}
