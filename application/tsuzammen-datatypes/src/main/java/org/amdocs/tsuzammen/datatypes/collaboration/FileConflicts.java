/*
 * Copyright © 2016 Amdocs Software Systems Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.amdocs.tsuzammen.datatypes.collaboration;

import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

public class FileConflicts {

  private String fileName;

  private byte[] local;
  private byte[] remote;

  private Collection<Conflict> conflicts;


  public InputStream getLocal(){
    return new ByteArrayInputStream(this.local);
  }

  public InputStream getRemote(){
    return new ByteArrayInputStream(this.remote);
  }



  public void setLocal(InputStream local) {
    this.local = FileUtils.toByteArray(local);
  }

  public void setLocal(byte[] local) {
    this.local = local;
  }

  public void setRemote(InputStream remote) {
    this.remote = FileUtils.toByteArray(remote);
  }

  public void setRemote(byte[] remote) {
    this.remote = remote;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Collection<Conflict> getConflicts() {
    return conflicts;
  }

  public void setConflicts(
      Collection<Conflict> conflicts) {
    this.conflicts = conflicts;
  }
}