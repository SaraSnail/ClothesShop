package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Clothes;

import java.util.ArrayList;

public class CommandPipeline {

    private ArrayList<ClothesProcessingCommand> pipeline = new ArrayList<>();

    public void addCommand(ClothesProcessingCommand command) {
        pipeline.add(command);
    }

    public Clothes execute(Clothes clothes) {
        Clothes result = clothes;
        for(ClothesProcessingCommand command : pipeline) {
            result = command.process(result);
        }
        return result;
    }
}
