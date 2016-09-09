package com.gofetchcode.search.tabula.POJOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Max on 08.09.2016.
 */


public class PagePOJO {
    @SerializedName("page")
    private final int page;
    @SerializedName("extraction_method")
    private final String extractionMethod;
    @SerializedName("selection_id")
    private final String selectionId;
    @SerializedName("x1")
    private final float x1;
    @SerializedName("y1")
    private final float y1;
    @SerializedName("width")
    private final float width;
    @SerializedName("height")
    private final float height;

    /**
     * Constructor with params
     *
     * @param page             int page counts
     * @param extractionMethod String extraction method type
     * @param selectionId      String selection id
     * @param x1               X-axis position of our top-left coordinate
     * @param y1               Y-axis position of our top-left coordinate
     * @param width            with of our Rectangle from X
     * @param height           height of our Rectangle from Y
     */
    //TODO make builder
    public PagePOJO(int page, String extractionMethod,
                    String selectionId, float x1, float y1,
                    float width, float height) {
        this.page = page;
        this.extractionMethod = extractionMethod;
        this.selectionId = selectionId;
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;

    }

    /**
     * Page number getter
     *
     * @return Page number
     */
    public int getPage() {
        return page;
    }

    public String getExtractionMethod() {
        return extractionMethod;
    }

    public String getSelectionId() {
        return selectionId;
    }

    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }


    /**
     * Override toString method
     *
     * @return String with object fields
     */
    @Override
    public String toString() {
        return "{\npage: " + page
                + "\n\textraction model: " + extractionMethod
                + "\n\tselectonID: " + selectionId
                + "\n\tx1: " + x1
                + "\n\ty1:" + y1
                + "\n\twidth:" + width
                + "\n\theight:" + height
                + "\n}";
    }
}
