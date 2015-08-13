/*
  Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FLOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.mysqlx.devapi;

import com.mysql.cj.mysqlx.FilterParams;

/**
 * @todo
 */
public abstract class FilterableStatement<T> {
    protected FilterParams filterParams = new FilterParams(getAllowRelationalColumns());

    public T where(String searchCondition) {
        this.filterParams.setCriteria(searchCondition);
        return (T) this;
    }

    public T sort(String sortFields) {
        this.filterParams.setOrder(sortFields);
        return (T) this;
    }

    public T orderBy(String sortFields) {
        this.filterParams.setOrder(sortFields);
        return (T) this;
    }

    public T limit(long numberOfRows) {
        this.filterParams.setLimit(numberOfRows);
        return (T) this;
    }

    /**
     * Should expression parsing allow relational columns?
     */
    protected abstract boolean getAllowRelationalColumns();
}
