package org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory;

import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.Table;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.ArtChair;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.Chair;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.ArtTable;

public class ArtFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ArtChair();
    }

    @Override
    public Table createTable() {
        return new ArtTable();
    }
}
