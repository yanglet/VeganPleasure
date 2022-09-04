package com.project.vegan.domain.diet.controller;

import com.project.vegan.domain.diet.request.DietSaveRequest;
import com.project.vegan.domain.diet.response.DietDto;
import com.project.vegan.domain.diet.service.DietService;
import com.project.vegan.domain.member.entity.Member;
import com.project.vegan.global.security.annotation.LoginMember;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/v1/api/diets")
public class DietController {
    private final DietService dietService;

    @ApiOperation("식단 목록 조회")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DietDto> getDiets(){
        return dietService.getDiets();
    }

    @ApiOperation("식단 저장")
    @PostMapping("/diet")
    @ResponseStatus(HttpStatus.CREATED)
    public DietDto save(@Validated @RequestBody DietSaveRequest dietSaveRequest,
                        @LoginMember Member member){
        return dietService.save(dietSaveRequest, member);
    }

    @ApiOperation("식단 상세 조회")
    @GetMapping("/{dietId}")
    @ResponseStatus(HttpStatus.OK)
    public DietDto getDiet(@PathVariable("dietId") Long dietId){
        return dietService.getDiet(dietId);
    }

    @ApiOperation("식단 수정")
    @PostMapping("/{dietId}")
    @ResponseStatus(HttpStatus.OK)
    public DietDto updateDiet(@PathVariable("dietId") Long dietId,
                              @Validated @RequestBody DietSaveRequest dietSaveRequest,
                              @LoginMember Member member){
        return dietService.update(dietSaveRequest, member, dietId);
    }

    @ApiOperation("식단 삭제")
    @DeleteMapping("/{dietId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDiet(@PathVariable("dietId") Long dietId,
                           @LoginMember Member member){
        dietService.delete(dietId, member);
    }
}