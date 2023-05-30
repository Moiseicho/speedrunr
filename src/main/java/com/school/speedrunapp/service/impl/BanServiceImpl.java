package com.school.speedrunapp.service.impl;

import com.school.speedrunapp.controller.resources.BanResource;
import com.school.speedrunapp.entity.Ban;
import com.school.speedrunapp.repository.BanRepository;
import com.school.speedrunapp.repository.UserRepository;
import com.school.speedrunapp.service.BanService;
import com.school.speedrunapp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

import static com.school.speedrunapp.mapper.BanMapper.BAN_MAPPER;

@Service
@RequiredArgsConstructor
public class BanServiceImpl implements BanService
{
    private final BanRepository banRepository;
    private final UserService userService;

    @Override
    public List<BanResource> findAll()
    {
        return BAN_MAPPER.toBanResources(banRepository.findAll());
    }

    @Override
    public BanResource getById(long id)
    {
        return BAN_MAPPER.toBanResource(banRepository.getReferenceById(id));
    }

    @Override
    public BanResource save(BanResource banResource)
    {
        Ban ban = BAN_MAPPER.fromBanResource(banResource);
        ban.setUser(userService.getById(banResource.getUserId()));
        return BAN_MAPPER.toBanResource(banRepository.save(ban));
    }

    @Override
    public BanResource update(BanResource banResource, long id)
    {
        Ban toUpdate = banRepository.getReferenceById(id);
        toUpdate.setBanDate(banResource.getBanDate());
        toUpdate.setBanMessage(banResource.getBanMessage());
        toUpdate.setUser(userService.getById(banResource.getUserId()));
        toUpdate.setBanTime(banResource.getBanTime());

        return BAN_MAPPER.toBanResource(banRepository.save(toUpdate));
    }

    @Override
    public void delete(long id)
    {
        banRepository.deleteById(id);
    }

    @Override
    public List<BanResource> getAllByName(String name)
    {
        return BAN_MAPPER.toBanResources(banRepository.getBansByUser(
                userService.getByName(name).orElseThrow(EntityNotFoundException::new)
            )
        );
    }

    @Override
    public List<BanResource> getPermaBans()
    {
        return BAN_MAPPER.toBanResources(banRepository.getPermaBans());
    }


}
