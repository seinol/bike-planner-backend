package ch.hsr.greatnamebackend.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(SampleController.COLLECTION_PATH)
public class SampleController {

    public static final String COLLECTION_PATH = "/sample";

    private static final String RESOURCE_SUBPATH = "{id}";

    public static final String RESOURCE_PATH = COLLECTION_PATH + "/" +  RESOURCE_SUBPATH;

    private final SampleRepository sampleRepository;

    public SampleController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @GetMapping()
    public List<Sample> readAll() {
        return sampleRepository.findAll();
    }
}
