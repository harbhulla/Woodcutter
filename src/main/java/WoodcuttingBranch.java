import net.eternalclient.api.data.ItemID;
import net.eternalclient.api.frameworks.tree.Branch;
import net.eternalclient.api.utilities.container.OwnedItems;

public class WoodcuttingBranch extends Branch
{
    @Override
    public boolean isValid()
    {
        return OwnedItems.contains(ItemID.BRONZE_AXE);
    }
}