package com.example.Controller.Command;

import com.example.Controller.Observer.EventManager;
import com.example.Model.BusinessObjects.Clothes.Clothes;

import java.util.ArrayList;

public class CommandPipeline {

    private ArrayList<ClothesProcessingCommand> pipeline = new ArrayList<>();
    private EventManager eventManager = EventManager.getInstance();

    public CommandPipeline() {

    }

    public void addCommand(ClothesProcessingCommand command) {
        pipeline.add(command);
    }

    public Clothes execute(Clothes clothes) {
        Clothes result = clothes;

        for(ClothesProcessingCommand command : pipeline) {
            result = command.process(result);
            System.out.println();

        }
        eventManager.notifyListeners(clothes.getName() + " created");

        return result;
    }
}
