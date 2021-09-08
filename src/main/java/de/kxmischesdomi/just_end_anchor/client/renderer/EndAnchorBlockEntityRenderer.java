package de.kxmischesdomi.just_end_anchor.client.renderer;

import de.kxmischesdomi.just_end_anchor.common.blocks.EndAnchorBlock;
import de.kxmischesdomi.just_end_anchor.common.entities.EndAnchorBlockEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
public class EndAnchorBlockEntityRenderer<T extends EndAnchorBlockEntity> extends EndPortalBlockEntityRenderer<T> {

	public EndAnchorBlockEntityRenderer(Context ctx) {
		super(ctx);
	}

	public void render(T endPortalBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
		if (endPortalBlockEntity.getCachedState().get(EndAnchorBlock.CHARGES) > 0) {
			Matrix4f matrix4f = matrixStack.peek().getModel();
			this.renderSide(endPortalBlockEntity, matrix4f, vertexConsumerProvider.getBuffer(this.getLayer()), 0.1238F, 0.8762F, 1, 1, 0.8762F, 0.8762F, 0.1238F, 0.1238F);
		}

	}

	private void renderSide(T entity, Matrix4f model, VertexConsumer vertices, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4) {
		if (entity.shouldDrawSide(Direction.UP)) {
			vertices.vertex(model, x1, y1, z1).next();
			vertices.vertex(model, x2, y1, z2).next();
			vertices.vertex(model, x2, y2, z3).next();
			vertices.vertex(model, x1, y2, z4).next();
		}

	}

}
