package org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory;

import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.Table;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.Chair;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.VictorianChair;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.VictorianTable;

public class VictorianFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
