package org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory;

import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.Table;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.Chair;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.ModernChair;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.ModernTable;

public class ModernFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
