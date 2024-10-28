import net.eternalclient.api.containers.Inventory;
import net.eternalclient.api.events.loadout.InventoryLoadout;
import net.eternalclient.api.events.loadout.WithdrawLoadoutEvent;
import net.eternalclient.api.frameworks.tree.Leaf;
import net.eternalclient.api.utilities.ReactionGenerator;
public class BankingLeaf extends Leaf
{
    @Override
    public boolean isValid()
    {

        return Inventory.isFull() || !Constants.woodCuttingEquipmentLoadOut.isFulfilled();
    }

    @Override
    public int onLoop()
    {
        new WithdrawLoadoutEvent(new InventoryLoadout().setLoadoutStrict(), Constants.woodCuttingEquipmentLoadOut)
                .setBuyRemainder(true)
                .execute();

        return ReactionGenerator.getPredictable();
    }
}