package javafx.test.workspace.not_related_folder.testOOD.finance;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Tradeable> {

    private final List<T> assetList;

    public Portfolio () {
        this.assetList = new ArrayList<>();
    }

    public void addAsset(T asset) {
        assetList.add(asset);
    }

    public double calculateTotalValue() {
        return assetList.stream()
                .map(T::getValue)
                .reduce(0.0, (a, b) -> a + b);
    }

}

