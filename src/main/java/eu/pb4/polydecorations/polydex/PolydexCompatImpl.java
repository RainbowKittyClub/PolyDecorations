package eu.pb4.polydecorations.polydex;

import eu.pb4.polydecorations.block.DecorationsBlocks;
import eu.pb4.polydecorations.block.other.GenericSingleItemBlockEntity;
import eu.pb4.polydex.api.v1.hover.HoverDisplayBuilder;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PolydexCompatImpl {
    // Show [item name] (Display Case) instead of just "Display Case" when hovering/targeting a Display Case with an item in it
    public static void register() {
        HoverDisplayBuilder.register(DecorationsBlocks.DISPLAY_CASE, PolydexCompatImpl::replaceName);
    }
    private static void replaceName(HoverDisplayBuilder builder) {
        if (builder.getTarget().blockEntity() instanceof GenericSingleItemBlockEntity be && !be.isEmpty()) {
            builder.setComponent(HoverDisplayBuilder.NAME, Text.empty()
                    .append(be.getStack().getName())
                    .append(Text.literal(" (")
                            .append(builder.getComponent(HoverDisplayBuilder.NAME))
                            .append(")").formatted(Formatting.GRAY))
            );
        }
    }
}