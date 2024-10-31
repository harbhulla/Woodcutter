import net.eternalclient.api.accessors.Skills;
import net.eternalclient.api.data.ItemID;
import net.eternalclient.api.events.loadout.EquipmentLoadout;
import net.eternalclient.api.wrappers.skill.Skill;

public class Constants
{

    public static EquipmentLoadout getWoodCuttingEquipmentLoadOut() {
        EquipmentLoadout woodCuttingEquipmentLoadOut = new EquipmentLoadout();
        if(Constants.currentLevel >= 1 && Constants.currentLevel < 5)
            return woodCuttingEquipmentLoadOut.addWeapon(ItemID.IRON_AXE);
        if(Constants.currentLevel >= 21 && Constants.currentLevel < 41)
            return woodCuttingEquipmentLoadOut.addWeapon(ItemID.MITHRIL_AXE);
        if(Constants.currentLevel > 41)
            return woodCuttingEquipmentLoadOut.addWeapon(ItemID.RUNE_AXE);

        return woodCuttingEquipmentLoadOut.addWeapon(ItemID.IRON_AXE);
    }

    public static int currentLevel = Skills.getRealLevel(Skill.WOODCUTTING);



}