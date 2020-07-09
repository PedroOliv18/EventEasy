package com.example.eventeasy.ui.home.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.servico_Titulo, item);
        ITEM_MAP.put(item.servico_Preco, item);
        ITEM_MAP.put(item.servico_Titulo, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem("titulo", "preço","tipo");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
//        public final String id;
        public final String servico_Titulo;
        public final String servico_Preco;
        public final String servico_Tipo;

        public DummyItem(String servico_Titulo, String servico_Preco, String servico_Tipo) {
            this.servico_Titulo = servico_Titulo;
            this.servico_Preco = servico_Preco;
            this.servico_Tipo = servico_Tipo;
        }

    }
}