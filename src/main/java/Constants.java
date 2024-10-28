import net.eternalclient.api.data.ItemID;
import net.eternalclient.api.events.loadout.EquipmentLoadout;
import net.eternalclient.api.events.loadout.InventoryLoadout;
import net.eternalclient.api.accessors.LocalPlayer;
import net.eternalclient.api.interfaces.Positionable;

public class Constants
{

    public static final EquipmentLoadout woodCuttingEquipmentLoadOut = new EquipmentLoadout()
            .addCape(ItemID.BLACK_CAPE)
            .addChest(ItemID.ADAMANT_PLATEBODY)
            .addLegs(ItemID.ADAMANT_PLATELEGS)
            .addFeet(ItemID.LEATHER_BOOTS)
            .addShield(ItemID.ADAMANT_KITESHIELD)
            .addWeapon(ItemID.BRONZE_AXE)
            .addAmulet(ItemID.AMULET_OF_POWER)
            .addHat(ItemID.ADAMANT_FULL_HELM);

}