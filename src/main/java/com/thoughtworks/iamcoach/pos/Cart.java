package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<String> inputs = new ArrayList<String>();

    public Cart(ArrayList<String> inputs, ArrayList<Item> items){
        this.inputs = inputs;
        this.items = items;
    }

    public double[] getNumbers() {

        double numbers[] = new double[items.size()];
        for(int i=0; i<items.size(); i++){
            for(int j=0; j<inputs.size(); j++){
                boolean canSplit = inputs.get(j).contains("-");
                if(canSplit){
                   numbers[i] +=  processSplitedBarcode(i, j);
                }else{
                    numbers[i] += processBarcode(i, j);
                }
            }
        }
        return numbers;
    }

    private double processSplitedBarcode(int i, int j){
        double number = 0;

        String[] barcodeAndNumber = inputs.get(j).split("-");
        if(items.get(i).getBarcode().equals(barcodeAndNumber[0])){
            number = Double.parseDouble(barcodeAndNumber[1]);
        }
        return number;
    }

    private double processBarcode(int i, int j){
        if(items.get(i).getBarcode().equals(inputs.get(j))){
            return 1.0;
        }
        return 0.0;
    }
}
