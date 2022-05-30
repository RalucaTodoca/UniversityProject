package models;

import java.util.Objects;

public class Author {
    private final String name_;
    private final String surname_;

    public Author(String full_name)
    {
        name_ = Objects.requireNonNullElse(full_name, "");
        surname_ = "";
    }

    public Author(String name, String surname)
    {
        name_ = Objects.requireNonNullElse(name, "");
        surname_ = Objects.requireNonNullElse(surname, "");
    }

    public Author(Author author)
    {
        name_ = author.name_;
        surname_ = author.surname_;
    }

    @Override
    public String toString()
    {
        return name_ + surname_;
    }

    public String getName() { return name_; }

    public String getSurname() { return surname_; }

    public void print()
    {
        System.out.print(this);
    }

    @Override
    public boolean equals(Object author)
    {
        if (author == this)
            return true;

        if (!(author instanceof Author))
            return false;

        return surname_.equalsIgnoreCase(((Author)author).surname_) && name_.equalsIgnoreCase(((Author)author).name_);
    }

}




