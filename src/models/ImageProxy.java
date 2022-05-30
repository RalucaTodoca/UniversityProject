package models;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ImageProxy extends Element implements Picture, Visitee {
    private final String url_;
    private final Dimension dim_;
    private models.Image realImage_;

    public ImageProxy(String url)
    {
        url_ = Objects.requireNonNullElse(url, "");
        dim_ = new Dimension(0, 0);
        realImage_ = null;
    }

    public models.Image loadImage()
    {
        if (realImage_ == null)
        {
            realImage_ = new models.Image(url_);
        }

        return realImage_;
    }

    public models.Image getRealImage() {
        return realImage_;
    }

    public String getUrl()
    {
        return url_;
    }

    public void setRealImage(models.Image image)
    {
        realImage_ = new Image(image);
    }

    @Override
    public String url()
    {
        return url_;
    }

    @Override
    public Dimension dim()
    {
        return dim_;
    }

    @Override
    public BufferedImage content()
    {
        return realImage_.getContent();
    }

    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    }

    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    }

    public Element getDocument()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitImageProxy(this);
    }
}
