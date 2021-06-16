package projetspring.sport.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import projetspring.sport.model.subscriber;
import projetspring.sport.repository.subscriberRepository;

@Service
public class subscriberService implements subscriberServiceInterface {

    @Autowired
    private subscriberRepository subscriberRepository;

    @Override
    public List<subscriber> getAllSubscriber() {
        return subscriberRepository.findAll();
    }

    @Override
    public void saveSubscriber(subscriber subscriber) {
        this.subscriberRepository.save(subscriber);
    }

    @Override
    public subscriber getSubscriberById(long id) {
        Optional<subscriber> optional = subscriberRepository.findById(id);
        subscriber subscriber = null;
        if (optional.isPresent()) {
            subscriber = optional.get();
        } else {
            throw new RuntimeException("Subscriber not found for id :: " + id);
        }
        return subscriber;
    }

    @Override
    public void deleteSubscriberById(long id) {
        this.subscriberRepository.deleteById(id);
    }

    @Override
    public Page<subscriber> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.subscriberRepository.findAll(pageable);
    }
}

