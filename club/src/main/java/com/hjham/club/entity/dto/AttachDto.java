package com.hjham.club.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachDto {
  private String uuid;
  private String origin;
  private boolean image;
  private String path;

  private long size;
  private String mime;
  private String fileName;
  private String ext;
  private String url;

  private Long num; // noteNum
}
