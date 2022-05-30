package models;

import services.BookStatistics;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Section extends Element implements Visitee {
    protected String title_;
    protected List<Element> content_;

    public Section(String title)
    {
        title_ = Objects.requireNonNullElse(title, "");
        content_ = new ArrayList<>();
    }

    public Section(String title, List<Element> content)
    {
        title_ = Objects.requireNonNullElse(title, "");
        content_ = new ArrayList<>(content);
    }

    public Section(Section section)
    {
        title_ = section.title_;
        content_ = new ArrayList<>(section.content_);
    }

    private <T> boolean containsObject(List<T> list, T object)
    {
        for (T iterator : list)
        {
            if (object.equals(iterator))
                return true;
        }

        return false;
    }

    private <T> boolean checkCollectionSubsetOfAnother(List<T> collection_1, List<T> collection_2)
    {
        for (T obj : collection_1)
        {
            if (!containsObject(collection_2, obj))
            {
                return false;
            }
        }

        return true;
    }

    // Compare the contents of two collections
    private <T> boolean compareList(List<T> collection_1, List<T> collection_2)
    {
        return collection_1.size() == collection_2.size() && checkCollectionSubsetOfAnother(collection_1, collection_2)
                && checkCollectionSubsetOfAnother(collection_2, collection_1);
    }

    public String getTitle()
    {
        return title_;
    }

    public List<Element> getContent()
    {
        return Collections.unmodifiableList(content_);
    }

    @Override
    public boolean equals(Object section)
    {
        if (section == this)
            return true;

        if (!(section instanceof Section))
            return false;

        return title_.equalsIgnoreCase(((Section)section).title_) && compareList(content_, ((Section)section).content_);
    }

    @Override
    public boolean add(Element element)
    {
        if (!element.getParent())
        {
            content_.add(element);
            element.setParent(true);

            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean remove(Element element)
    {
        boolean removalResult = content_.remove(element);

        if (removalResult)
        {
            element.setParent(false);
        }

        return removalResult;
    }

    @Override
    public Element get(int index)
    {
        if (index < content_.size())
        {
            return content_.get(index);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSection(this);
    }

//    @Override
//    public void accept(BookStatistics bookStatistics) {
//        bookStatistics.visitSection(this);
//    }

}
