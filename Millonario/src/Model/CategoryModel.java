/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class CategoryModel {
    
    private int categoryId;
    private String categoryName;
    private int roundIdFk;

    public CategoryModel(int categoryId, String categoryName, int roundIdFk) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.roundIdFk = roundIdFk;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRoundIdFk() {
        return roundIdFk;
    }

    public void setRoundIdFk(int roundIdFk) {
        this.roundIdFk = roundIdFk;
    }
    
    
    
}
