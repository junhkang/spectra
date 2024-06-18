package com.example.spectra.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("indexDTO")
public class IndexDTO {
    private long relId;
    private long indexRelId;
    private String schemaName;
    private String relName;
    private String indexRelName;
    private long idxScan;
    private long idxTupRead;
    private long idxTupFetch;
}
