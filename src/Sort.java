import java.util.Objects;

public class Sort {
    private String userWord;
    private Integer count;

    public String getUserWord() {
        return userWord;
    }

    public Integer getCount() {
        return count;
    }

    public Sort(String userWord, Integer count) {
        this.userWord = userWord;
        this.count = count;
    }

    @Override
    public String toString() {
        String str = "userWord: " + userWord + " count: " + count;
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sort sort = (Sort) o;
        return count == sort.count && Objects.equals(userWord, sort.userWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userWord, count);
    }

}
