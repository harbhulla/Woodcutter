import net.eternalclient.api.data.ItemID;
import net.eternalclient.api.frameworks.tree.Branch;
import net.eternalclient.api.utilities.container.OwnedItems;

public class WoodcuttingBranch extends Branch
{

    public WoodcuttingBranch() {
        addLeafs(new BankingLeaf(),
                new TraversingLeaf(),
                new WoodcuttingLeaf()
        );
    }
    @Override
    public boolean isValid()
    {

        return OwnedItems.contains(ItemID.BRONZE_AXE) || OwnedItems.contains(ItemID.IRON_AXE) ||
                OwnedItems.contains(ItemID.MITHRIL_AXE) || OwnedItems.contains(ItemID.RUNE_AXE);
    }
}