package org.vulkanb.eng.graph;

import java.util.*;

public class VulkanModel {

    private final String modelId;
    private final List<VulkanAnimationData> vulkanAnimationDataList;
    private final List<VulkanModel.VulkanMesh> vulkanMeshList;
    // TODO: This may not be required. Temporary
    private boolean hasAnimations;

    public VulkanModel(String modelId, boolean hasAnimations) {
        this.modelId = modelId;
        vulkanMeshList = new ArrayList<>();
        vulkanAnimationDataList = new ArrayList<>();
        this.hasAnimations = hasAnimations;
    }

    public void addVulkanAnimationData(VulkanAnimationData vulkanAnimationData) {
        vulkanAnimationDataList.add(vulkanAnimationData);
    }

    public void addVulkanMesh(VulkanModel.VulkanMesh vulkanMesh) {
        vulkanMeshList.add(vulkanMesh);
    }

    public String getModelId() {
        return modelId;
    }

    public List<VulkanAnimationData> getVulkanAnimationDataList() {
        return vulkanAnimationDataList;
    }

    public List<VulkanModel.VulkanMesh> getVulkanMeshList() {
        return vulkanMeshList;
    }

    public boolean hasAnimations() {
        return hasAnimations;
    }

    public static class VulkanAnimationData {
        private List<VulkanAnimationFrame> vulkanAnimationFrameList;

        public VulkanAnimationData() {
            vulkanAnimationFrameList = new ArrayList<>();
        }

        public void addVulkanAnimationFrame(VulkanAnimationFrame vulkanAnimationFrame) {
            vulkanAnimationFrameList.add(vulkanAnimationFrame);
        }

        public List<VulkanAnimationFrame> getVulkanAnimationFrameList() {
            return vulkanAnimationFrameList;
        }
    }

    public static record VulkanAnimationFrame(int jointMatricesOffset) {

    }

    public static record VulkanMaterial(int globalMaterialIdx) {
    }

    public static record VulkanMesh(int verticesSize, int numIndices, int verticesOffset, int indicesOffset,
                                    int globalMaterialIdx, int weightsOffset) {
    }
}