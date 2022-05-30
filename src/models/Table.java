package models;

import services.BookStatistics;

import java.util.Objects;

public class Table extends Element implements Visitee {
    private final String title_;

    public Table(String title)
    {
        title_ = Objects.requireNonNullElse(title, "");
    }

    public Table(Table table)
    {
        title_ = table.title_;
    }

    public String getTitle() { return title_; }

    @Override
    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitTable(this);
    }
}


