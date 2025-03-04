package com.example.Controller.Command;

import com.example.Model.BusinessObjects.Clothes.Clothes;

public interface ClothesProcessingCommand {
    public Clothes process(Clothes clothes);
}
