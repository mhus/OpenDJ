/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at legal-notices/CDDLv1_0.txt
 * or http://forgerock.org/license/CDDLv1.0.html.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at legal-notices/CDDLv1_0.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2006-2008 Sun Microsystems, Inc.
 *      Portions Copyright 2015 ForgeRock AS
 */
package org.opends.server.api;



import org.opends.server.types.RestoreConfig;



/**
 * This interface defines a set of methods that may be used to notify
 * various Directory Server components whenever a backend restore task
 * is about to begin or has just completed.  Note that these methods
 * will only be invoked for the restore task and not for offline
 * restore processing.
 */
@org.opends.server.types.PublicAPI(
     stability=org.opends.server.types.StabilityLevel.VOLATILE,
     mayInstantiate=false,
     mayExtend=true,
     mayInvoke=false)
public interface RestoreTaskListener
{
  /**
   * Performs any processing that might be necessary just before the
   * server begins processing on a restore task.  This should include
   * pausing interaction with the provided backend while the restore
   * is in progress.
   *
   * @param  backend  The backend to be restored.
   * @param  config   Configuration information about the restore to
   *                  be performed.
   */
  void processRestoreBegin(Backend backend,
                                  RestoreConfig config);



  /**
   * Performs any processing that might be necessary after the server
   * has completed processing on a restore task.  Note that this will
   * always be called when restore processing completes, regardless of
   * whether it was successful.
   *
   * @param  backend     The backend that was restored.
   * @param  config      Configuration information about the restore
   *                     that was performed.
   * @param  successful  Indicates whether the restore operation
   *                     completed successfully.
   */
  void processRestoreEnd(Backend backend, RestoreConfig config,
                                boolean successful);
}
