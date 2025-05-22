package com.example.recyclerview;

public class ModelFruit {
    int image;
    String name;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelFruit(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
//ModelFruit card1 = new ModelFruit();
//card1.setName("te string");

//
//ModelFruit card2 = new ModelFruit(3333,"the text for card 2");
//card1.image;
//card2.imag