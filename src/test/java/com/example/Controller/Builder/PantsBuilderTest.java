package com.example.Controller.Builder;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Controller.Observer.EventManager;
import com.example.Model.BusinessObjects.CEO;
import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PantsBuilderTest {
    //Kanske ändra till ClothesBuilder

    //Mock:a allt!!
    //Test för valda saker och för saker man inte ska kunna välja

    private PantsBuilder pantsBuilder;
    private Pants pants;
    private EventManager eManager = EventManager.getInstance();

    @Mock
    private EventManager eventManager;
    private CEO ceoMock;

    @BeforeEach
    public void setUp() {
        pantsBuilder = new PantsBuilder();
        pants = new Pants();

        MockitoAnnotations.openMocks(this);
        ceoMock = mock(CEO.class);
        eventManager = mock(EventManager.class);
        eventManager.addListener(ceoMock);


    }

    @Test
    void noExceptionInBuild() {

        pants = (Pants) pantsBuilder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build();

        assertEquals(Size.MEDIUM, pants.getSize());

    }

    //Skarp
    @Test
    void catchIfSizeIsNull() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pants = (Pants) pantsBuilder
                    .addColor(Color.BLACK)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No size chosen", exceptionThrown.getMessage());

    }

    @Test
    void catchIfMaterialIsNull() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pants = (Pants) pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addColor(Color.BLACK)
                    .build();
        });

        assertEquals("No material chosen", exceptionThrown.getMessage());

    }

    @Test
    void catchIfColorIsNull() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pants = (Pants) pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No color chosen", exceptionThrown.getMessage());

    }

    @Test
    void createClothesReturnPants() {

        //Fixa
        Clothes pants = pantsBuilder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build();

        assertInstanceOf(Pants.class, pants, "Created object should be instance of Pants");
        //assertTrue(pants instanceof Pants, "Created object should be instance of Pants");

    }

    @Test
    void notifyEventManagerWhenNewPantsCreated() {
        pantsBuilder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build();

        verify(eventManager, times(1)).notifyListeners("Pants started creation");
    }


}