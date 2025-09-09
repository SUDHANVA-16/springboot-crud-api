package com.demo.spring_boot;

import org.springframework.stereotype.Service;

import java.util.List;

//this makes it available to use in other classes
@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;

    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository, AiService aiService
    ) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {

        //fetch all the information
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the tech stack %s that %s has given
                Provide a full learning path and recommendations for this person
                """.formatted(
                        softwareEngineer.getTechstack(),
                        softwareEngineer.getName()
        );
        String chatResponse = aiService.chat(prompt);
        softwareEngineer.setLearningPath(chatResponse);
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                id + "not found" ));
    }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    id + " not found"
            );
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer update){
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        id + "not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechstack(update.getTechstack());
        softwareEngineerRepository.save(softwareEngineer);

    }
}
